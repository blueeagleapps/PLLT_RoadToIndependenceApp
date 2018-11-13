package pl.f44red.android.independenceapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.util.Date;

@Entity(tableName = "history_event_table")
public class HistoryEvent {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @NonNull
    @ColumnInfo(name = "country_code")
    private String countryCode;

    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;

    @NonNull
    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "long_description")
    private String longDescription;

    @ColumnInfo(name = "hyperlink")
    private String hyperlink;

    // constructors

    public HistoryEvent(@NonNull String title, @NonNull String countryCode) {
        this.title = title;
        this.countryCode = countryCode;
    }


    // getters & setters


    @NonNull
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(@NonNull String countryCode) {
        this.countryCode = countryCode;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public Date getDate() {
        return date;
    }

    public void setDate(@NonNull Date date) {
        this.date = date;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }
}
