package com.cognizant.ormlearn.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name="stock")
public class Stock {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="st_id")
private int id;
@Column(name="st_code")
private String code;
@Column(name="st_date")
private Date date;
@Column(name="st_open")
private double open;
@Column(name="st_close")
private double close;
@Column(name="st_volume")
private long volume;
public int getId() {
return id;
}
public void setId(int id) {
this.id = id;
}
public String getCode() {
return code;
}
public void setCode(String code) {
this.code = code;
}
public Date getDate() {
return date;
}
public void setDate(Date date) {
this.date = date;
}
public double getOpen() {
return open;
}
public void setOpen(double open) {
this.open = open;
}
public double getClose() {
return close;
}
public void setClose(double close) {
this.close = close;
}
public long getVolume() {
return volume;
}
public void setVolume(long volume) {
this.volume = volume;
}
@Override
public String toString() {
return "Stock [id=" + id + ", code=" + code + ", date=" + date + ", open=" + open + ", close=" + close + ", volume=" + volume + "]";
}
}
