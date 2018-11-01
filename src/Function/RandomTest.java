package Function;
import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		Random rnd = new Random();
		int[] a = new int[10];
		int count = 0;
		while(count<a.length) {
			int rndnam = rnd.nextInt(a.length)+1;
			boolean check = false;
			System.out.println("ランダムで作られた数:"+rndnam);
			System.out.println("以下の配列にランダムで作られたものがないかチェック");
			for(int j = 0;j< count;j++) {
				System.out.print("/"+a[j]);
				if(a[j] == rndnam) {
					System.out.println();
					System.out.println("配列の中にランダムで作った数字がすでにありました///"+a[j]);
					check = true;
					break;
				}
			}
			if(check==false) {
				System.out.println();
				System.out.println("ランダムで制作した数字は配列の中になかったので"+rndnam+"をインデックス"+count+"のところへ入れます。");
				a[count]=rndnam;
				count++;
			}
		}
		for(int i = 0;i < a.length;i++) {
			System.out.print(a[i]+"/");
		}
	}

}
