package java_midterm;
import java.util.Scanner;

public class jmr20191575_mid1 {
	public static int gameRPS() {		//가위바위보를 실행하고 결과를 반환함
		Scanner scanner = new Scanner(System.in);
		int result; //1은 승리 2는 패배 3은 무승부
		while(true){		
			System.out.println("가위 바위 보 중 내고싶은걸 내시오 :");
			String mine = scanner.nextLine();
			int comrand = (int) ((Math.random() * 3) + 1); // comrand변수를 선언하고 1~3중 무작위 값을 저장 (1은 가위, 2는 바위, 3은 보)
			String computer = null;
			
			if(comrand == 1) {
				computer = "가위";
			} else if(comrand == 2) {
				computer = "바위";
			} else if(comrand == 3) {
				computer = "보";
			} else {
				System.out.println("알 수 없는 오류입니다.");
				continue;
			}
			if((mine.equals("가위") && computer.equals("보")) || (mine.equals("바위") && computer.equals("가위")) || (mine.equals("보") && computer.equals("바위"))) {
				System.out.printf("당신은 %s를 냈고 컴퓨터는 %s를 냈습니다.\n승리했습니다!\n", mine, computer);
				result = 1;
				break;
			} else if((mine.equals("가위") && computer.equals("바위")) || (mine.equals("바위") && computer.equals("보")) || (mine.equals("보") && computer.equals("가위"))) {
				System.out.printf("당신은 %s를 냈고 컴퓨터는 %s를 냈습니다.\n패배했습니다.\n", mine, computer);
				result = 2;
				break;
			} else if(mine.equals(computer)) {
				System.out.printf("당신은 %s를 냈고 컴퓨터는 %s를 냈습니다.\n무승부 입니다.\n", mine, computer);
				result = 3;
				break;
			} else {
				System.out.println("잘못 입력했습니다\n");
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("가위바위보 게임을 시작합니다!");
		Scanner scanner = new Scanner(System.in);
		int winTimes = 0; //유저의 승리횟수를 기록하는 변수를 선언 및 초기화
		normalGame: while(true) {	//가위바위보 승패가 갈릴때 까지 반복 연승게임이나 n판선승제 승리시 탈출 위해 라벨 이용
			int result = gameRPS();	//gameRPS()메서드를 실행
			if(result == 1) { 	//일반게임 승리시 연승도전게임 기회
				winTimes += 1;
				System.out.println("연승에 도전하시겠습니까? 도전할 시 '예'를 치시오 안할시 아무글자나 치시오 : ");
				String moreWins = scanner.nextLine(); //연승 도전 여부를 물음
				if(moreWins.equals("예")) {
					while(true) { //연승도전을 위한 반복
						result = gameRPS();	//gameRPS()메서드를 실행
						if(result == 1) { //승리시 승리횟수를 1회 올리고 재반복
							winTimes += 1;
							System.out.printf("현재까지 승리횟수는 %d회 입니다\n", winTimes);
							continue;
						}else if(result == 2) { // 패배시 총 승리횟수를 알려주고 반복문 종료
							System.out.printf("총 승리횟수는 %d회 입니다.\n", winTimes);
							break;	//결과가 나왔으므로 게임 종료
						}else { continue;}
					}break;
				}else { break;}
			}else if(result == 2) {	//일반게임 패배시 n판선승제 기회
				int roundN = 3;	//현재 몇판 몇선승제인지 기록하는 변수
				int comWin = 1;	//컴퓨터가 이긴횟수를 기록하는 변수
				while(true) { //n판선승제에서도 패배했을 시 n+2판선승제 도전위해 반복
					System.out.println("결과에 승복하십니까? 승복할시 아무글자나, 못할시 '다시도전'을 치시오: ");
					String moreChance = scanner.nextLine();
					if(moreChance.equals("다시도전")) {
						System.out.printf("%d판 %d선승제로 진행하겠습니다.", roundN, ((int)(roundN / 2)+1));
						while(true) { //n판선승제 게임을 위해 반복
							result = gameRPS();	//gameRPS()메서드를 실행
							if(result == 1) {
								winTimes += 1;
								System.out.printf("현재 %d판 %d선승제, 스코어는 (유저 %d : %d 컴퓨터) 입니다.\n",roundN, ((int)(roundN / 2)+1), winTimes, comWin);
								if(winTimes == ((int)(roundN / 2)+1)) {	//현재 스코어로 승패 판별
									System.out.printf("결국 승리하였습니다.\n");
									break normalGame;	//승리하였으므로 게임 종료
								}else if(comWin == ((int)(roundN / 2)+1)) {
									System.out.printf("끝내 패배하였습니다.\n");
									break;
								}else { continue; }	//스코어가 나지 않았을 시 재대결 위해 재반복
							}else if(result == 2) {
								comWin += 1;
								System.out.printf("현재 %d판 %d선승제, 스코어는 (유저 %d : %d 컴퓨터) 입니다.\n",roundN, ((int)(roundN / 2)+1), winTimes, comWin);
								if(winTimes == ((int)(roundN / 2)+1)) {	//현재 스코어로 승패 판별
									System.out.printf("결국 승리하였습니다.\n");
									break normalGame;	//승리하였으므로 게임 종료
								}else if(comWin == ((int)(roundN / 2)+1)) {
									System.out.printf("끝내 패배하였습니다.\n");
									break;
								}else { continue; }	//스코어가 나지 않았을 시 재대결 위해 재반복
							}else { continue; }	//무승부시 재대결 위해 재반복
						}roundN += 2;	//n+2판선승제 위해 2를 더함
					}else {break;}
				}break;
			}else { continue; }
		}System.out.println("게임을 종료합니다.");
			
	}
}
