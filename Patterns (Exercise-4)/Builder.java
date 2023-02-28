package exercise4;

public class Builder {
	
	public static void main(String[] args) {
		
		Laptop laptop = new Laptop.BuildLaptop().setMotherBoard("intel").setRam("16gb ram").setHarddisk("500Gb SSD").setSsd("1tb hdd ssd").setVgacard("4GB graphics card").build();
		System.out.println(laptop);
	}
}
class Laptop{
	
	class Cabinet{
		String motherboard,ram,harddisk,vgacard,hdd;
		public Cabinet(String motherboard, String ram, String harddisk, String vgacard, String hdd) {
			this.motherboard = motherboard;
			this.ram = ram;
			this.harddisk = harddisk;
			this.vgacard = vgacard;
			this.hdd = hdd;
		}
		
		@Override
		public String toString() {
			return "Cabinet [motherboard=" + motherboard + ", ram=" + ram + ", harddisk=" + harddisk + ", vgacard="
					+ vgacard + ", hdd=" + hdd + "]";
		}
		
	}
	
	Cabinet cabinet;
	String brand;
	public Laptop(BuildLaptop bl) {
		cabinet = new Cabinet(bl.motherboard, bl.ram, bl.harddisk, bl.vgacard, bl.hdd);
		brand = "Hp Laptop";
	}
	
	@Override
	public String toString() {
		return "Laptop [c=" + cabinet + ", brand=" + brand + "]";
	}
	
	static class BuildLaptop{
		String motherboard, ram, harddisk, vgacard, hdd;
		public BuildLaptop setMotherBoard(String motherboard) {
			this.motherboard = motherboard;
			return this;
		}
		public BuildLaptop setRam(String ram) {
			this.ram=ram;
			return this;
		}
		
		public BuildLaptop setHarddisk(String harddisk) {
			this.harddisk = harddisk;
			return this;
		}
		public BuildLaptop setVgacard(String vgacard) {
			this.vgacard = vgacard;
			return this;
		}
		public BuildLaptop setSsd(String hdd) {
			this.hdd = hdd;
			return this;
		}
		
		public Laptop build() {
			return new Laptop(this);
		}
	}
}