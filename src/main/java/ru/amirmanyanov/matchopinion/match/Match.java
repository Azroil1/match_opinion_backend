package ru.amirmanyanov.matchopinion.match;

public interface Match {
    boolean match(String id, Long clientLike);
    Object getMatch();
}
