package main;

import java.util.Objects;

public class Computer {
	public static final String[] OS_OPTIONS = {"Macintosh", "Windows", "Linux"};
	public static final int CAPACITY_MIN_PWR = 0;
	public static final int CAPACITY_MAX_PWR = 12;
	public static final double VERSION_MIN = 1.0;
	public static final double VERSION_MAX = 20.0;
	
	public static class Builder{
		private String os;
		private double os_version;
		private boolean intel_chip; // if intel FALSE, assumed AMD
		private int ram;
		private int ssd;
		private String serial_number;
		
		
		public Builder os(final String os) {
			this.os = os;
			return this;
		}
		
		public Builder os_version(final double os_version) {
			this.os_version = os_version;
			return this;
		}
		
		public Builder intel_chip(final boolean intel) {
			this.intel_chip = intel ? true : false;
			return this;
		}
		
		
		public Builder ram(final int ram) {
			this.ram = ram;
			return this;
		}
		
		public Builder ssd(final int ssd) {
			this.ssd = ssd;
			return this;
		}

		public Builder serial_number(final String serial_number) {
			this.serial_number = serial_number;
			return this;
		}
		
		public Computer build() {
			return new Computer(this.os, this.os_version, this.intel_chip,
					this.ram, this.ssd, this.serial_number);
		}

	}
	
	private final String os;
	private final double os_version;
	private final boolean intel_chip;
	private final int ram;
	private final int ssd;
	private final String serial_number;
	
	
	public Computer(String os, double os_version, boolean intel_chip, int ram, int ssd,
			String serial_number) {
		this.os = os;
		this.os_version = os_version;
		this.intel_chip = intel_chip;
		this.ram = ram;
		this.ssd = ssd;
		this.serial_number = serial_number;
	}
	
	public String toString() {
		String str = "";
		str += "\n--------------------\n";
		str += "Operating System: " + this.os + "\n" ;
		str += "OS Version: " + this.os_version + "\n" ;
		str += "Chip: " + (intel_chip ? "Intel" : "AMD") + "\n" ;
		str += "RAM (GB): " + this.ram + "\n" ;
		str += "SSD Capacity (GB): " + this.ssd + "\n" ;
		str += "Serial Number: " + this.serial_number + "\n" ;
		str += "--------------------\n";
		
		return str;
	}

	public static Computer createRandomComputer() {
		Computer.Builder randomComp = new Computer.Builder();
		java.util.Random rand = new java.util.Random();
		
		String os = Computer.OS_OPTIONS[rand.nextInt(3)];
		
		double os_version = rand.nextDouble(VERSION_MIN, VERSION_MAX);
		
		boolean intel_chip = rand.nextBoolean();
		
		int ram = (int) Math.pow(2, rand.nextInt(CAPACITY_MIN_PWR,CAPACITY_MAX_PWR));
				
		int ssd = (int) Math.pow(2, rand.nextInt(CAPACITY_MIN_PWR,CAPACITY_MAX_PWR));
		
		String serial = RandomStringUtils.randomNumeric(10);
		
		randomComp.os(os);		
		randomComp.os_version(os_version);		
		randomComp.intel_chip(intel_chip);		
		randomComp.ram(ram);		
		randomComp.ssd(ssd);		
		randomComp.serial_number(serial);
		
		return randomComp.build();
		
	}

	public String getOs() {
		return os;
	}

	public double getOs_version() {
		return os_version;
	}

	public boolean isIntel_chip() {
		return intel_chip;
	}

	public int getRam() {
		return ram;
	}

	public int getSsd() {
		return ssd;
	}

	public String getSerial_number() {
		return serial_number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(intel_chip, os, os_version, ram, serial_number, ssd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computer other = (Computer) obj;
		return intel_chip == other.intel_chip && Objects.equals(os, other.os)
				&& Double.doubleToLongBits(os_version) == Double.doubleToLongBits(other.os_version) && ram == other.ram
				&& Objects.equals(serial_number, other.serial_number) && ssd == other.ssd;
	}
	
	
	
	
}
