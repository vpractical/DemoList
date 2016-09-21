package demo.shape;

import android.util.Log;

/**
 * Created by Johnny on 2016/9/14.
 */
public class Acl {
	public Acl() {
	}



	public void want(Bcl bcl){
		Log.i("A","a中wangt执行 + bcl = " + bcl.toString());
		bcl.doing();
	}
}
