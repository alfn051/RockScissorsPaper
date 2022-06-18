package java_midterm;
import java.util.Scanner;

public class jmr20191575_mid1 {
	public static int gameRPS() {		//������������ �����ϰ� ����� ��ȯ��
		Scanner scanner = new Scanner(System.in);
		int result; //1�� �¸� 2�� �й� 3�� ���º�
		while(true){		
			System.out.println("���� ���� �� �� ��������� ���ÿ� :");
			String mine = scanner.nextLine();
			int comrand = (int) ((Math.random() * 3) + 1); // comrand������ �����ϰ� 1~3�� ������ ���� ���� (1�� ����, 2�� ����, 3�� ��)
			String computer = null;
			
			if(comrand == 1) {
				computer = "����";
			} else if(comrand == 2) {
				computer = "����";
			} else if(comrand == 3) {
				computer = "��";
			} else {
				System.out.println("�� �� ���� �����Դϴ�.");
				continue;
			}
			if((mine.equals("����") && computer.equals("��")) || (mine.equals("����") && computer.equals("����")) || (mine.equals("��") && computer.equals("����"))) {
				System.out.printf("����� %s�� �°� ��ǻ�ʹ� %s�� �½��ϴ�.\n�¸��߽��ϴ�!\n", mine, computer);
				result = 1;
				break;
			} else if((mine.equals("����") && computer.equals("����")) || (mine.equals("����") && computer.equals("��")) || (mine.equals("��") && computer.equals("����"))) {
				System.out.printf("����� %s�� �°� ��ǻ�ʹ� %s�� �½��ϴ�.\n�й��߽��ϴ�.\n", mine, computer);
				result = 2;
				break;
			} else if(mine.equals(computer)) {
				System.out.printf("����� %s�� �°� ��ǻ�ʹ� %s�� �½��ϴ�.\n���º� �Դϴ�.\n", mine, computer);
				result = 3;
				break;
			} else {
				System.out.println("�߸� �Է��߽��ϴ�\n");
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println("���������� ������ �����մϴ�!");
		Scanner scanner = new Scanner(System.in);
		int winTimes = 0; //������ �¸�Ƚ���� ����ϴ� ������ ���� �� �ʱ�ȭ
		normalGame: while(true) {	//���������� ���а� ������ ���� �ݺ� ���°����̳� n�Ǽ����� �¸��� Ż�� ���� �� �̿�
			int result = gameRPS();	//gameRPS()�޼��带 ����
			if(result == 1) { 	//�Ϲݰ��� �¸��� ���µ������� ��ȸ
				winTimes += 1;
				System.out.println("���¿� �����Ͻðڽ��ϱ�? ������ �� '��'�� ġ�ÿ� ���ҽ� �ƹ����ڳ� ġ�ÿ� : ");
				String moreWins = scanner.nextLine(); //���� ���� ���θ� ����
				if(moreWins.equals("��")) {
					while(true) { //���µ����� ���� �ݺ�
						result = gameRPS();	//gameRPS()�޼��带 ����
						if(result == 1) { //�¸��� �¸�Ƚ���� 1ȸ �ø��� ��ݺ�
							winTimes += 1;
							System.out.printf("������� �¸�Ƚ���� %dȸ �Դϴ�\n", winTimes);
							continue;
						}else if(result == 2) { // �й�� �� �¸�Ƚ���� �˷��ְ� �ݺ��� ����
							System.out.printf("�� �¸�Ƚ���� %dȸ �Դϴ�.\n", winTimes);
							break;	//����� �������Ƿ� ���� ����
						}else { continue;}
					}break;
				}else { break;}
			}else if(result == 2) {	//�Ϲݰ��� �й�� n�Ǽ����� ��ȸ
				int roundN = 3;	//���� ���� ��������� ����ϴ� ����
				int comWin = 1;	//��ǻ�Ͱ� �̱�Ƚ���� ����ϴ� ����
				while(true) { //n�Ǽ����������� �й����� �� n+2�Ǽ����� �������� �ݺ�
					System.out.println("����� �º��Ͻʴϱ�? �º��ҽ� �ƹ����ڳ�, ���ҽ� '�ٽõ���'�� ġ�ÿ�: ");
					String moreChance = scanner.nextLine();
					if(moreChance.equals("�ٽõ���")) {
						System.out.printf("%d�� %d�������� �����ϰڽ��ϴ�.", roundN, ((int)(roundN / 2)+1));
						while(true) { //n�Ǽ����� ������ ���� �ݺ�
							result = gameRPS();	//gameRPS()�޼��带 ����
							if(result == 1) {
								winTimes += 1;
								System.out.printf("���� %d�� %d������, ���ھ�� (���� %d : %d ��ǻ��) �Դϴ�.\n",roundN, ((int)(roundN / 2)+1), winTimes, comWin);
								if(winTimes == ((int)(roundN / 2)+1)) {	//���� ���ھ�� ���� �Ǻ�
									System.out.printf("�ᱹ �¸��Ͽ����ϴ�.\n");
									break normalGame;	//�¸��Ͽ����Ƿ� ���� ����
								}else if(comWin == ((int)(roundN / 2)+1)) {
									System.out.printf("���� �й��Ͽ����ϴ�.\n");
									break;
								}else { continue; }	//���ھ ���� �ʾ��� �� ���� ���� ��ݺ�
							}else if(result == 2) {
								comWin += 1;
								System.out.printf("���� %d�� %d������, ���ھ�� (���� %d : %d ��ǻ��) �Դϴ�.\n",roundN, ((int)(roundN / 2)+1), winTimes, comWin);
								if(winTimes == ((int)(roundN / 2)+1)) {	//���� ���ھ�� ���� �Ǻ�
									System.out.printf("�ᱹ �¸��Ͽ����ϴ�.\n");
									break normalGame;	//�¸��Ͽ����Ƿ� ���� ����
								}else if(comWin == ((int)(roundN / 2)+1)) {
									System.out.printf("���� �й��Ͽ����ϴ�.\n");
									break;
								}else { continue; }	//���ھ ���� �ʾ��� �� ���� ���� ��ݺ�
							}else { continue; }	//���ºν� ���� ���� ��ݺ�
						}roundN += 2;	//n+2�Ǽ����� ���� 2�� ����
					}else {break;}
				}break;
			}else { continue; }
		}System.out.println("������ �����մϴ�.");
			
	}
}
