package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByOrder();
    }

    private enum Month {
        JANUARY(1, 31),
        FEBRUARY(2, 28),
        MARCH(3, 31),
        APRIL(4, 30),
        MAY(5, 31),
        JUNE(6, 30),
        JULY(7, 31),
        AUGUST(8, 31),
        SEPTEMBER(9, 30),
        OCTOBER(10, 31),
        NOVEMBER(11, 30),
        DECEMBER(12, 31);

        private final int order;
        private final int days;

        private Month(final int order, final int days) {
            this.order = order;
            this.days = days;
        }

        /**
         * This method iterates through all the {@code values} of the {@link Month} {@code Enum}.
         * It keeps track of the number of {@code matches} found that defines which the following behaviour is based on.
         * @param month as a {@code String} representing the month to retrieve.
         * @return The requested month of type {@link Month}.
         * @throws IllegalArgumentException Ambiguous or invalid input.
         */
        public static Month fromString(final String month) {
            int matches = 0;
            Month result = null;
            for (Month currentMonth : Month.values()) {
                if (currentMonth.name().startsWith(month.toUpperCase())) {
                    matches++;
                    if (matches > 1) {
                        throw new IllegalArgumentException("Couldn't find a match (ambiguous name): " + month);
                    }
                    result = currentMonth;
                }
            }
            if (Objects.isNull(result)) {
                throw new IllegalArgumentException("There's no such month with the provided name: " + month);
            }
            return result;
        }
    }

    private class SortByDays implements Comparator<String> {

        @Override
        public int compare(final String arg0, final String arg1) {
            final Month month1 = Month.fromString(arg0);
            final Month month2 = Month.fromString(arg1);
            return Integer.compare(month1.days, month2.days);
        }
        
    }

    private class SortByOrder implements Comparator<String> {

        @Override
        public int compare(final String arg0, final String arg1) {
            final Month month1 = Month.fromString(arg0);
            final Month month2 = Month.fromString(arg1);
            return Integer.compare(month1.order, month2.order);
        }

    }

}
