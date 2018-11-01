package Function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadText {
	List<Integer> indentNamList = new ArrayList<Integer>();
	ReadText(String url){
		try {
			// ファイルのパスを指定する
			File file = new File(url);

			// ファイルが存在しない場合に例外が発生するので確認する
			if (!file.exists()) {
				System.out.print("ファイルが存在しません");
				return;
			}

			// BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String data;
			int indentNum = 0;
			while ((data = bufferedReader.readLine()) != null) {
				Pattern frontS = Pattern.compile("\\{");
				Pattern rearS = Pattern.compile("\\}");
				Matcher frontM = frontS.matcher(data);
				Matcher rearM = rearS.matcher(data);

				System.out.println(data);
				if(frontM.find()){
					indentNum++;
				}
				if(rearM.find()){
					indentNum--;
				}
				indentNamList.add(indentNum);
			}
			for(int n : indentNamList){
				System.out.println(n);
			}

				// 最後にファイルを閉じてリソースを開放する
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
