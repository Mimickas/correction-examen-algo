package itu.correction_examen.demo.record;

import itu.correction_examen.demo.entity.Correcteur;

import java.math.BigDecimal;

public record RecordNoteCorrecteur(Correcteur correcteur, BigDecimal note) {
}
