package Entity07212;


public class DaftarEntity07212 {
    private PembeliEntity07212 pembeli;
    private boolean isVerified;
    private int indexKue;
    
    public DaftarEntity07212(PembeliEntity07212 pembeli, boolean isVerified, int indexKue) {
        this.pembeli = pembeli;
        this.isVerified = isVerified;
        this.indexKue = indexKue;
    }

    public PembeliEntity07212 getPembeli() {
        return pembeli;
    }

    public void setPembeli(PembeliEntity07212 pembeli) {
        this.pembeli = pembeli;
    }

    public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public int getIndexKue() {
        return indexKue;
    }

    public void setIndexKue(int indexKue) {
        this.indexKue = indexKue;
    }
}
