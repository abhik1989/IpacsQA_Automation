
package com.ipacs.qa.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import org.openqa.selenium.WebElement;

public class SortUtil {

	public static boolean isSortedAscending(List<String> list) {
		List<String> sorted = new ArrayList<>(list);
		Collections.sort(sorted);
		return list.equals(sorted);
	}

	public static boolean isSortedDescending(List<String> list) {
		List<String> sorted = new ArrayList<>(list);
		Collections.sort(sorted, Collections.reverseOrder());
		return list.equals(sorted);
	}

	public static List<String> extractTextFromElements(List<WebElement> elements) {
		List<String> textList = new ArrayList<>();
		for (WebElement element : elements) {
			textList.add(element.getText().trim().toLowerCase());
		}
		return textList;
	}

	public static boolean isSortedAscendingNumbers(List<String> list) {
		List<Double> original = list.stream().map(Double::parseDouble).toList();
		List<Double> sorted = new ArrayList<>(original);
		Collections.sort(sorted);
		return original.equals(sorted);
	}

	public static boolean isSortedDescendingNumbers(List<String> list) {
		List<Double> original = list.stream().map(Double::parseDouble).toList();
		List<Double> sorted = new ArrayList<>(original);
		sorted.sort(Collections.reverseOrder());
		return original.equals(sorted);
	}

	public static boolean isSortedAscendingDates(List<String> list, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			List<Date> original = new ArrayList<>();
			for (String s : list)
				original.add(sdf.parse(s));
			List<Date> sorted = new ArrayList<>(original);
			Collections.sort(sorted);
			return original.equals(sorted);
		} catch (ParseException e) {
			throw new RuntimeException("Date parsing failed: " + e.getMessage());
		}
	}

	public static boolean isSortedDescendingDates(List<String> list, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			List<Date> original = new ArrayList<>();
			for (String s : list)
				original.add(sdf.parse(s));
			List<Date> sorted = new ArrayList<>(original);
			sorted.sort(Collections.reverseOrder());
			return original.equals(sorted);
		} catch (ParseException e) {
			throw new RuntimeException("Date parsing failed: " + e.getMessage());
		}
	}
	
	public static boolean isSortedAscendingNatural(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        sorted.sort(new NaturalOrderComparator());
        return list.equals(sorted);
    }

    public static boolean isSortedDescendingNatural(List<String> list) {
        List<String> sorted = new ArrayList<>(list);
        sorted.sort(new NaturalOrderComparator().reversed());
        return list.equals(sorted);
    }

    // Comparator for natural order sorting
    static class NaturalOrderComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            return extractChunks(a).compareTo(extractChunks(b));
        }

        private ChunkedString extractChunks(String str) {
            List<String> chunks = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            boolean isDigit = Character.isDigit(str.charAt(0));

            for (char ch : str.toCharArray()) {
                if (Character.isDigit(ch) == isDigit) {
                    current.append(ch);
                } else {
                    chunks.add(current.toString());
                    current = new StringBuilder().append(ch);
                    isDigit = !isDigit;
                }
            }
            chunks.add(current.toString());
            return new ChunkedString(chunks);
        }

        private static class ChunkedString implements Comparable<ChunkedString> {
            List<String> chunks;

            ChunkedString(List<String> chunks) {
                this.chunks = chunks;
            }

            @Override
            public int compareTo(ChunkedString other) {
                for (int i = 0; i < Math.min(this.chunks.size(), other.chunks.size()); i++) {
                    String a = this.chunks.get(i);
                    String b = other.chunks.get(i);

                    int cmp;
                    if (a.chars().allMatch(Character::isDigit) && b.chars().allMatch(Character::isDigit)) {
                        cmp = Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
                    } else {
                        cmp = a.compareToIgnoreCase(b);
                    }

                    if (cmp != 0) return cmp;
                }
                return Integer.compare(this.chunks.size(), other.chunks.size());
            }
        }
}
}
    
