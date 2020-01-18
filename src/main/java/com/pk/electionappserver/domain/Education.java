package com.pk.electionappserver.domain;

import java.io.Serializable;

public enum Education implements Serializable {
    PODSTAWOWE,
    ZAWODOWE,
    SREDNIE,
    LICENCJAT,
    INZYNIER,
    MAGISTER,
    DOKTOR,
    PROFESOR;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
