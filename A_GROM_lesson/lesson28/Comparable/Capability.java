package A_GROM_lesson.lesson28.Comparable;

import java.util.Date;

public class Capability implements Comparable<Capability> {
    private long id;
    private String channelName;
    private String fingerprint;
    private boolean isActive;
    private Date dateCreated;

    public Capability(long id, String channelName, String fingerprint, boolean isActive, Date dateCreated) {
        this.id = id;
        this.channelName = channelName;
        this.fingerprint = fingerprint;
        this.isActive = isActive;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getChannelName() {
        return channelName;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public boolean isActive() {
        return isActive;
    }

    public Date getDateCreated() {
        return dateCreated;
    }


    //-1 OR 0 OR 1  - возможны три значения (отрицательное (на местах), 0, 1 - положит (меняем местами)
    @Override
    public int compareTo(Capability o) {
        System.out.println("compareTo is used");
        return (int) (this.id-o.getId());
    }
    //1001,1005,990
    // step1:  1001-1005=-4 - отрицательное, значит элементы остаются на своих местах
    //1001,1005,990
    //step2:   1005-990=15- положительное, значит элементы меняются местами
    //1001,990,1005
    //step3: 1001,990 = 11 - положительное, значит элементы меняются местами
    //990,1001,1005


    @Override
    public String toString() {
        return "Capability{" +
                "id=" + id +
                ", channelName='" + channelName + '\'' +
                ", fingerprint='" + fingerprint + '\'' +
                ", isActive=" + isActive +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
