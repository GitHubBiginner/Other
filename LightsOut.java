import java.util.*;

class LightsOut{
	
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean[][] temp = new boolean[N + 2][N + 2];
		
		
		for(int i = 1 ; i < N + 1 ; i ++){
			for(int j = 1 ; j < N + 1; j ++){
				temp[i][j] = (sc.nextInt() == 1);
			}
		}
		
		boolean[][] light = new boolean[N + 2][N + 2];
		
		int M = 7;
		
		int[] index = new int[M];
		
		for(index[0] = 0 ; index[0] < N * N ; index[0] ++){
			for(index[1] = index[0] + 1 ; index[1] < N * N ; index[1] ++){
				for(index[2] = index[1] + 1 ; index[2] < N * N ; index[2] ++){
					for(index[3] = index[2] + 1 ; index[3] < N * N ; index[3] ++){
						for(index[4] = index[3] + 1 ; index[4] < N * N ; index[4] ++){
							for(index[5] = index[4] + 1 ; index[5] < N * N ; index[5] ++){
								for(index[6] = index[5] + 1 ; index[6] < N * N ; index[6] ++){
									resetArray(temp,light);
//				printLight(light);
									push(light , index[0] / N ,index[0] % N );
//				printLight(light);
									push(light , index[1] / N ,index[1] % N );
//				printLight(light);
									push(light , index[2] / N ,index[2] % N );
//				printLight(light);
									push(light , index[3] / N ,index[3] % N );
//				printLight(light);
									push(light , index[4] / N ,index[4] % N );
//				printLight(light);
									push(light , index[5] / N ,index[5] % N );
//				printLight(light);
									push(light , index[6] / N ,index[6] % N );
									if(isTotalFalse(light)  || isTotalTrue(light)  ){
										for(int i = 0 ; i < index.length ; i ++){
											System.out.print (index[i] + " ");
										}
										System.out.println();
//										break;
									}
	//						printLight(light);
								}
							}
						}
					}
				}
			}
		}
	}
	
	static boolean isTotalFalse( boolean[][] array){
		boolean result = true;
		
		for(int i = 1 ; i < array.length -1 ; i ++){
			for(int j = 1 ; j < array[i].length - 1; j ++){
				if(array[i][j]){
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	static boolean isTotalTrue( boolean[][] array){
		boolean result = true;
		
		for(int i = 1 ; i < array.length -1 ; i ++){
			for(int j = 1 ; j < array[i].length - 1; j ++){
				if(!array[i][j]){
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	
	static void push( boolean[][] array ,int a , int b ){
		int x = a + 1;
		int y = b + 1;
		array[x ][y] = !array[x][y];
		array[x - 1][y] = !array[x - 1][y];
		array[x][y - 1] = !array[x][y - 1];
		array[x + 1][y] = !array[x + 1][y];
		array[x][y + 1] = !array[x][y + 1];
	}
	
	static void printLight(boolean[][] array){
		for(int i = 1 ; i < array.length - 1; i ++){
			for(int j = 1 ; j < array[i].length - 1 ; j ++){
				System.out.print( array[i][j] ? "1" : "0" );
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	static void resetArray(boolean[][] fromArray ,boolean[][] toArray ){
		for(int i = 0 ; i < toArray.length ; i++){
			for(int j = 0 ;j < toArray[i].length ; j ++){
				toArray[i][j] = fromArray[i][j];
			}
		}
	}
}
