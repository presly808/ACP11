package ua.artcode.checkpoint;

import java.util.Date;

/**
 * Created by DNK on 06.12.2015.
 */
public class CardStaff {
    private String fam;
    private String im;
    private Date dateAdmissionWork; // дата зачисления на работу
    private Date dateDismissalWork; // дата увольнения с работы

    public CardStaff(String fam, String im){
        this.fam = fam;
        this.im  = im;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(fam).append(" ");
        sb.append(im);
        sb.append('}');
        return sb.toString();
    }

    public void setFam(String fam) {
        this.fam = fam;
    }

    public void setIm(String im) {
        this.im = im;
    }

    public void setDateAdmissionWork(Date dateAdmissionWork) {
        this.dateAdmissionWork = dateAdmissionWork;
    }

    public void setDateDismissalWork(Date dateDismissalWork) {
        this.dateDismissalWork = dateDismissalWork;
    }

    public String getFam() {
        return fam;
    }

    public String getIm() {
        return im;
    }

    public Date getDateAdmissionWork() {
        return dateAdmissionWork;
    }

    public Date getDateDismissalWork() {
        return dateDismissalWork;
    }
}
