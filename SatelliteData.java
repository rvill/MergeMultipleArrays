/*
 * rvill@mit.edu
   copyright(c) 2013
 */


package pset4b;

import java.sql.Array;
import java.util.Comparator;



public class SatelliteData implements Comparable {

	public double longitude;
	public double cloudCover;
	public double temperature;

	private double a[], c[];
	int d, h, i, j, k;



	public SatelliteData(){

		longitude = this.longitude;
		cloudCover = this.cloudCover;
		temperature = this.temperature;

	}


	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	public Comparable mergeTwoArrays(Comparable a[], Comparable b[]){
		Comparable d = a.length + b.length;
		c = new double[(Integer) d];
		h=i=j=0;
		Comparable t[] = null;

		while((h < a.length) && (j<b.length)){
			if(a[h].compareTo(b[j]) <= 0){
				c[i] = (Double) a[h];
				h = h+1;
			}else{
				c[i] = (Double) a[h];
				i = i+1;
			}

			if (h >= a.length){
				for (k=j; k < b.length; k++)
				{
					c[i] = (Double) b[k];
					i = i+1;
				}
			} else {
				for (k=h; k<a.length; k++)
				{
					c[i] = (Double) a[k];
					i=i+1;
				}
			}

		}

		return d;
	}

}
