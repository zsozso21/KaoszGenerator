// Decompiled by DJ v3.11.11.95 Copyright 2009 Atanas Neshkov  Date: 2010.07.24. 13:32:46
// Home Page: http://members.fortunecity.com/neshkov/dj.html  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Jartassag.java

package kaosz.model.bean;

import java.util.ArrayList;
import java.util.Map;

// Referenced classes of package kaosz.model.bean:
//            Karakter

public class Jartassag {

	public Jartassag() {
	}

	public String getNev() {
		return nev;
	}

	public void setNev(String nev) {
		this.nev = nev;
	}

	public String getSzuksegesFoErtekNev() {
		return szuksegesFoErtekNev;
	}

	public void setSzuksegesFoErtekNev(String szuksegesFoErtekNev) {
		this.szuksegesFoErtekNev = szuksegesFoErtekNev;
	}

	public int[] getSzuksegesFoErtekSzint() {
		return szuksegesFoErtekSzint;
	}

	public void setSzuksegesFoErtekSzint(int szuksegesFoErtekSzint[]) {
		this.szuksegesFoErtekSzint = szuksegesFoErtekSzint;
	}

	public ArrayList getSzuksegesJartassagok() {
		return szuksegesJartassagok;
	}

	public void setSzuksegesJartassagok(ArrayList szuksegesJartassagok) {
		this.szuksegesJartassagok = szuksegesJartassagok;
	}

	public ArrayList getSzuksegesJartassagokVagy() {
		return szuksegesJartassagokVagy;
	}

	public void setSzuksegesJartassagokVagy(ArrayList szuksegesJartassagokVagy) {
		this.szuksegesJartassagokVagy = szuksegesJartassagokVagy;
	}

	public int[] getJpIgeny() {
		return jpIgeny;
	}

	public void setJpIgeny(int jpIgeny[]) {
		this.jpIgeny = jpIgeny;
	}

	public String getLeiras() {
		return leiras;
	}

	public void setLeiras(String leiras) {
		this.leiras = leiras;
	}

	public int[] getAtszamoltJpIgeny() {

		int atszamoltJpIgeny[] = new int[11];

		for (int i = 1; i <= 10; i++)
			atszamoltJpIgeny[i] = jpAtszamolo(jpIgeny[i], ((Integer) Karakter
					.getFoErtekek().get(szuksegesFoErtekNev)).intValue(),
					szuksegesFoErtekSzint[i]);

		return atszamoltJpIgeny;
	}

	private int jpAtszamolo(int jp, int meglevo, int szukseges) {
		int dif = meglevo - szukseges;
		int szorzo = 100;
		if (dif < -20)
			szorzo = 200;
		if (-20 <= dif && dif < -10)
			szorzo = 130;
		if (-10 <= dif && dif < 0)
			szorzo = 115;
		if (20 <= dif && dif < 30)
			szorzo = 85;
		if (30 <= dif)
			szorzo = 70;
		int eredmeny = (jp * szorzo) / 100;
		return eredmeny;
	}

	private String nev;
	private String szuksegesFoErtekNev;
	private int szuksegesFoErtekSzint[];
	private ArrayList szuksegesJartassagok;
	private ArrayList szuksegesJartassagokVagy;
	private int jpIgeny[];
	private String leiras;
}
