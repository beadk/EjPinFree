package kode_gen;

import java.util.*;

public class Kode_gen {
	Random gen = new Random();
	private int kodeLængde = 5;
	String kode = "";

	public String kode(String kode, int i) {
		if (i == kodeLængde) {
			return kode;
		} else {
			if (i == 0) {
				kode = "";
			}
			i++;
			return kode(kode + "" + gen.nextInt(10), i);
		}
	}

	public String mockKode(String kode, int i) {
		if (i == kodeLængde) {
			return kode;
		} else {
			if (i == 0) {
				kode = "";
			}
			i++;
			return mockKode(kode + "" + 0, i);
		}
	}

	public byte[] genSalt() {
		byte[] salt = new byte[8];
		gen.nextBytes(salt);
		return salt;
	}

}
