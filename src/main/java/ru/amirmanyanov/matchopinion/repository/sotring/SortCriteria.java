package ru.amirmanyanov.matchopinion.repository.sotring;

public enum SortCriteria {

    YEAR_ASC(SortField.YEAR, SortOrder.ASC),
    YEAR_DESC(SortField.YEAR, SortOrder.DESC),
    DURATION_ASC(SortField.DURATION, SortOrder.ASC),
    DURATION_DESC(SortField.DURATION, SortOrder.DESC),
    RATING_ASC(SortField.RATING, SortOrder.ASC);

    private final SortField sortField;
    private final SortOrder sortOrder;

    SortCriteria(SortField sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }

    public SortField getSortField() {
        return sortField;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
