package ru.amirmanyanov.matchopinion.repository.sotring;

import jakarta.persistence.criteria.Expression;

public enum SortField {
    RATING("rating"),
    DURATION("duration"),
    YEAR("year");
    private String value;
    SortField(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
