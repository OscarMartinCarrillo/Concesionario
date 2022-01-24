package org.izv.omc.concesionario.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class Coche implements Parcelable {
    private long ref;
    private String titulo;
    private String combustible;
    private int km;
    private String cambio;
    private int potencia;
    private int npuertas;
    private String color;
    private int year;
    private String url;
    private String imagenPrincipal;
    private int precio;
    private String lugar;
    private String descr;
    private String[] imagenes;

    public Coche() {
    }

    protected Coche(Parcel in) {
        ref = in.readLong();
        titulo = in.readString();
        combustible = in.readString();
        km = in.readInt();
        cambio = in.readString();
        potencia = in.readInt();
        npuertas = in.readInt();
        color = in.readString();
        year = in.readInt();
        url = in.readString();
        imagenPrincipal = in.readString();
        precio = in.readInt();
        lugar = in.readString();
        descr = in.readString();
        imagenes = in.createStringArray();
    }

    public static final Creator<Coche> CREATOR = new Creator<Coche>() {
        @Override
        public Coche createFromParcel(Parcel in) {
            return new Coche(in);
        }

        @Override
        public Coche[] newArray(int size) {
            return new Coche[size];
        }
    };

    public long getRef() {
        return ref;
    }

    public void setRef(long ref) {
        this.ref = ref;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getNpuertas() {
        return npuertas;
    }

    public void setNpuertas(int npuertas) {
        this.npuertas = npuertas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImagenPrincipal() {
        return imagenPrincipal;
    }

    public void setImagenPrincipal(String imagenPrincipal) {
        this.imagenPrincipal = imagenPrincipal;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(String[] imagenes) {
        this.imagenes = imagenes;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "ref=" + ref +
                ", titulo='" + titulo + '\'' +
                ", combustible='" + combustible + '\'' +
                ", km=" + km +
                ", cambio='" + cambio + '\'' +
                ", potencia=" + potencia +
                ", npuertas=" + npuertas +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", url='" + url + '\'' +
                ", imagenPrincipal='" + imagenPrincipal + '\'' +
                ", precio=" + precio +
                ", lugar='" + lugar + '\'' +
                ", descr='" + descr + '\'' +
                ", imagenes=" + Arrays.toString(imagenes) +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(ref);
        parcel.writeString(titulo);
        parcel.writeString(combustible);
        parcel.writeInt(km);
        parcel.writeString(cambio);
        parcel.writeInt(potencia);
        parcel.writeInt(npuertas);
        parcel.writeString(color);
        parcel.writeInt(year);
        parcel.writeString(url);
        parcel.writeString(imagenPrincipal);
        parcel.writeInt(precio);
        parcel.writeString(lugar);
        parcel.writeString(descr);
        parcel.writeStringArray(imagenes);
    }
}
