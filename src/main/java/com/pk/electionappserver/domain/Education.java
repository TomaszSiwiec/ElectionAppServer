package com.pk.electionappserver.domain;

import java.io.Serializable;

public enum Education implements Serializable {
    PODSTAWOWE,
    ZAWODOWE,
    ŚREDNIE,
    LICENCJAT,
    INŻYNIER,
    MAGISTER,
    DOKTOR,
    PROFESOR;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
