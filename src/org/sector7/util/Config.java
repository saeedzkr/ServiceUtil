package org.sector7.util;



import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.util.JSONPObject;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by s.zakipour on 04/04/2016.
 */

@XmlRootElement
public class Config {




    private String hour;
    private String minute;
    private String seccond;
    private long enabled;


    @XmlElement(name = "hour")
    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @XmlElement(name = "minute")
    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    @XmlElement(name = "seccond")
    public String getSeccond() {
        return seccond;
    }

    public void setSeccond(String seccond) {
        this.seccond = seccond;
    }


    @XmlElement(name = "enabled")
    public long getEnabled() {
        return enabled;
    }

    public void setEnabled(long enabled) {
        this.enabled = enabled;
    }


    @Override
    @JsonCreator
    public String toString() {

        final StringBuffer sb = new StringBuffer("Config{");
        sb.append("hour='").append(hour).append('\'');
        sb.append(", minute='").append(minute).append('\'');
        sb.append(", seccond='").append(seccond).append('\'');
        sb.append(", enabled=").append(enabled);
        sb.append('}');
        return sb.toString();
    }

    public Config() {
    }


    @JsonCreator
    public Config(@JsonProperty("hour")String hour
            , @JsonProperty("minute")String minute
            , @JsonProperty("seccond")String seccond
            , @JsonProperty("enabled")long enabled)
    {
        this.hour = hour;
        this.minute = minute;
        this.seccond = seccond;
        this.enabled = enabled;
    }
}

