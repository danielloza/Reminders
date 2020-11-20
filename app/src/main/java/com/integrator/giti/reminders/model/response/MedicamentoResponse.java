package com.integrator.giti.reminders.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicamentoResponse {
    @SerializedName("medicamentoId")
    @Expose
    private Integer medicamentoId;
    @SerializedName("nombre")
    @Expose
    private String nombre;
    @SerializedName("img_medicamento")
    @Expose
    private Integer imgMedicamento;
    @SerializedName("pacienteId")
    @Expose
    private Integer pacienteId;
    @SerializedName("tipoId")
    @Expose
    private Integer tipoId;
    @SerializedName("nombrePaciente")
    @Expose
    private String nombrePaciente;
    @SerializedName("tipoJarabe")
    @Expose
    private String tipoJarabe;

    public Integer getMedicamentoId() {
        return medicamentoId;
    }

    public void setMedicamentoId(Integer medicamentoId) {
        this.medicamentoId = medicamentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getImgMedicamento() {
        return imgMedicamento;
    }

    public void setImgMedicamento(Integer imgMedicamento) {
        this.imgMedicamento = imgMedicamento;
    }

    public Integer getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Integer pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getTipoJarabe() {
        return tipoJarabe;
    }

    public void setTipoJarabe(String tipoJarabe) {
        this.tipoJarabe = tipoJarabe;
    }

}
