package demo.toolbar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Johnny on 2016/9/21.
 */
public class HelloMsg implements Parcelable{
	private String msg;
	private int pid;

	public HelloMsg(String msg, int pid){
		this.msg = msg;
		this.pid = pid;
	}

	protected HelloMsg(Parcel in) {
		msg = in.readString();
		pid = in.readInt();
	}

	public static final Creator<HelloMsg> CREATOR = new Creator<HelloMsg>() {
		@Override
		public HelloMsg createFromParcel(Parcel in) {
			return new HelloMsg(in);
		}

		@Override
		public HelloMsg[] newArray(int size) {
			return new HelloMsg[size];
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(msg);
		dest.writeInt(pid);
	}
}
