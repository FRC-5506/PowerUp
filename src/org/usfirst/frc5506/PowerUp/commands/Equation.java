package org.usfirst.frc5506.PowerUp.commands;

/*import org.apache.commons.math3.analysis.UnivariateFunction;
/*import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;*/

/*public class Equation implements UnivariateFunction {//this entire thing can be deleted if we do pathDistance manually
	
	public Equation(double f, double g) {
		this.f = f;
		this.g = g;
		calculateCoefficients(f, g);
	}

	public void inputPoint(double f) {
		this.f = f;
		calculateCoefficients(f, g);
	}
	
	public void inputPoint(boolean gMode, double g) {
		this.g = g;
		calculateCoefficients(f, g);
	}
	
	public void inputPoint(double f, double g) {
		this.f = f;
		this.g = g;
		calculateCoefficients(f, g);
	}

	private void calculateCoefficients(double f2, double g2) {
		r = Math.sqrt(Math.pow(f, 2)+Math.pow(g, 2));//r = v|f^2 + g^2
		a = -g/r;
		b = Math.pow(r, 2)/Math.pow(f, 2);//b = r^2/f^2
	}
	
	public double value(double x) {
		return a*Math.sqrt(r*r-b*x*x)-a*r;
	}

	/*@Override
	public DerivativeStructure value(DerivativeStructure deriv) throws DimensionMismatchException {
		return Equation;
	}*/
	
	/*private double f, g, a, b, r;

}*/
