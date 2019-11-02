package com.uday.design.chess;

import java.util.Objects;

public class Spot {

    String id;

    Piece piece;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return Objects.equals(id, spot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
