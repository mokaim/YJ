package Pattern;

public class SingletonClass {
	private SingletonClass() {}
	private static SingletonClass Instance = null;
	
	public static SingletonClass getInstance() {
		if(Instance == null)
			Instance = new SingletonClass();
		return Instance;
	}

	// userTableDAO
	public int userInsertCnt = 0;
	public int userDeleteCnt = 0;
	public int userUpdateCnt = 0;
	// writeTableDAO
	public int writeInsertCnt = 0;
	public int writeDeleteCnt = 0;
	public int writeUpdateCnt = 0;
}
