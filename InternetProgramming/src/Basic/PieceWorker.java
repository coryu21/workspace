package Basic;
public class PieceWorker extends Employee {
	private double wage;
	private int pieces;

	public PieceWorker(String first, String last, String ssn,
			double wagePerPiece, int piecesProduced) {
		super(first, last, ssn);
		wage = wagePerPiece;
		pieces = piecesProduced;
	}

	public void setWage(double wagePerPiece) {
		wage = wagePerPiece;
	}

	public double getWage() {
		return wage;
	}

	public void setPieces(int piecesProduced) {
		pieces = piecesProduced;
	}

	public int getPieces() {
		return pieces;
	}

	@Override
	public double earnings() {
		return getWage() * getPieces();
	}

	public String toString() {
		String printName = "piece worker : " + getFirstName() + " "
				+ getLastName() + "\n";
		String printSsn = "social security number : "
				+ getSocialSecuriyNumber() + "\n";
		String printWage = "wage per piece : $" + getWage()
				+ "  pieces produced : " + getPieces();
		return printName + printSsn + printWage;
	}
}
