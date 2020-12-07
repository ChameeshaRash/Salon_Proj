package lk.ijse.salon.model;

public class CommonDTO {
    private AppointmentDTO appointmentDTO;
    private TreatmentDTO treatmentDTO;
    private TreatementDetailsDTO treatementDetailsDTO;

    public CommonDTO() {
    }

    public CommonDTO(AppointmentDTO appointmentDTO, TreatmentDTO treatmentDTO) {
        this.appointmentDTO = appointmentDTO;
        this.treatmentDTO = treatmentDTO;
    }

    public CommonDTO(AppointmentDTO appointmentDTO, TreatmentDTO treatmentDTO, TreatementDetailsDTO treatementDetailsDTO) {
        this.appointmentDTO = appointmentDTO;
        this.treatmentDTO = treatmentDTO;
        this.treatementDetailsDTO = treatementDetailsDTO;
    }

    public AppointmentDTO getAppointmentDTO() {
        return appointmentDTO;
    }

    public void setAppointmentDTO(AppointmentDTO appointmentDTO) {
        this.appointmentDTO = appointmentDTO;
    }

    public TreatmentDTO getTreatmentDTO() {
        return treatmentDTO;
    }

    public void setTreatmentDTO(TreatmentDTO treatmentDTO) {
        this.treatmentDTO = treatmentDTO;
    }

    public TreatementDetailsDTO getTreatementDetailsDTO() {
        return treatementDetailsDTO;
    }

    public void setTreatementDetailsDTO(TreatementDetailsDTO treatementDetailsDTO) {
        this.treatementDetailsDTO = treatementDetailsDTO;
    }

    @Override
    public String toString() {
        return "CommonDTO{" +
                "appointmentDTO=" + appointmentDTO +
                ", treatmentDTO=" + treatmentDTO +
                ", treatementDetailsDTO=" + treatementDetailsDTO +
                '}';
    }
}
