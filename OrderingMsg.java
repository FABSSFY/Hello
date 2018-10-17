import java.util.Scanner;

public class OrderingMsg {
	public static void main(String[] args) {
		// 1.数据主体
		String[] names = new String[4];// 订餐人
		String[] msg = new String[4];// 餐品信息
		int[] times = new int[4];// 送餐时间
		String[] address = new String[4];// 送餐地址
		int[] status = new int[4];// 订餐状态 0预定1完成
		double[] sum = new double[4];// 总金额

		// 初始化2条订单信息
		names[0] = "林天";
		msg[0] = "红烧牛头面 1份";
		times[0] = 10;
		address[0] = "北京海淀";
		status[0] = 0;
		sum[0] = 18.0;

		names[1] = "林天";
		msg[1] = "伟天魔术棒 2份";
		times[1] = 12;
		address[1] = "北京海淀";
		status[1] = 1;
		sum[1] = 50.0;

		names[2] = "林天";
		msg[2] = "红烧牛头面 1份";
		times[2] = 10;
		address[2] = "北京海淀";
		status[2] = 0;
		sum[2] = 18.0;

		names[3] = "林天";
		msg[3] = "红烧牛头面 1份";
		times[3] = 10;
		address[3] = "北京海淀";
		status[3] = 0;
		sum[3] = 18.0;
		// 初始化3条餐品信息
		String[] megName = { "红烧牛头面", "伟天魔术棒", "时令蔬菜类" };
		double[] price = { 18.0, 25.0, 10.0 };
		int[] good = new int[3];

		int end = 0;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("欢迎使用”吃货联盟订餐系统“");
			System.out.println("*********************");
			System.out.println("1.我要订餐");
			System.out.println("2.查看餐袋");
			System.out.println("3.签收订单");
			System.out.println("4.删除订单");
			System.out.println("5.我要点赞");
			System.out.println("6.退出系统");
			System.out.println("*********************");
			System.out.println("请选择：");
			int choose = input.nextInt();
			boolean flag = false;
			switch (choose) {
			// 1.订餐
			case 1:
				System.out.println("***我要订餐***");
				System.out.println("序号\t" + "菜名\t\t" + "单价\t");
				for (int i = 0; i < price.length; i++) {
					System.out.println(i + 1 + "\t" + megName[i] + "\t"
							+ price[i] + "元\t");
				}
				for (int i = 0; i < names.length; i++) {
					if (names[i] == null) {
						flag = true;
						System.out.println("请输入订餐人姓名:");
						names[i] = input.next();

						System.out.println("请选择您要点的菜品编号:");
						int number = input.nextInt();
						System.out.println("选择您需要的份数:");
						int count = input.nextInt();
						msg[i] = megName[number - 1] + " " + count + "份";

						System.out.println("请输入送餐时间（10-20）:");
						times[i] = input.nextInt();
						while (times[i] < 10 || times[i] > 20) {
							System.out.println("您输入的时间有误，请重新输入:");
							times[i] = input.nextInt();
						}
						System.out.println("请输入送餐地点:");
						address[i] = input.next();

						double money = price[number - 1];
						double sumoney = money * count;
						double extra = sumoney >= 50.0 ? 0.0 : 6.0;
						sum[i] = sumoney + extra;

						System.out.println("订餐成功");
						System.out.println("您定的是：" + msg[i]);
						System.out.println("送餐时间：" + times[i] + "点");
						System.out.println("餐费：" + money + "送餐费:" + extra + "");
						System.out.println("总金额：" + sum[i]);
						break;
					}
				}
				if (!flag) {
					System.out.println("订单已满");
				}
				break;
			case 2:
				System.out.println("***查看餐袋***");
				System.out.println("序号\t" + "订餐人\t" + "餐品信息\t\t" + "送餐日期\t"
						+ "送餐地址\t" + "总金额\t" + "订单状态");
				for (int i = 0; i < names.length; i++) {
					if (names[i] != null) {
						String stu = status[i] == 0 ? "已预订" : "已完成";
						System.out.println(i + 1 + "\t" + names[i] + "\t"
								+ msg[i] + "\t" + times[i] + "\t" + sum[i]
								+ "\t" + address[i] + "\t" + stu);
					}
				}
				break;
			case 3:
				System.out.println("***签收订单***");
				System.out.println("请输入要签收的订单序号:");
				int num2 = input.nextInt();
				if (names[num2 - 1] == null) {
					System.out.println("您选择的订单不存在");
				} else {
					if (status[num2 - 1] == 1) {
						System.out.println("您选择的订单已经签收，不能再次签收");
					} else {
						status[num2 - 1] = 1;
					}
				}
				break;
			case 4:
				System.out.println("***删除订单***");
				System.out.println("请输入您想删除的订单号：");
				int num3 = input.nextInt();
				if (names[num3 - 1] != null) {
					for (int i = num3; i < names.length; i++) {
						names[i - 1] = names[i];
						msg[i - 1] = msg[i];
						times[i - 1] = times[i];
						address[i - 1] = address[i];
						sum[i - 1] = sum[i];
						status[i - 1] = status[i];
					}
					names[names.length - 1] = null;
					// msg[msg.length-1]=null;
					// times[times.length-1]=0;
					//
					//
					//	
				} else {
					System.out.println("您所输入的订单号不存在");
				}
				break;
			case 5:
				System.out.println("***我要点赞***");
				System.out.println("序号\t" + "菜名\t\t" + "单价\t" + "点赞数");
				for (int i = 0; i < price.length; i++) {
					System.out.println(i + 1 + "\t" + megName[i] + "\t"
							+ price[i] + "元\t" + good[i] + "赞");
				}
				System.out.println("请输入需要点赞的菜品序号：");
				int num4 = input.nextInt();
				good[num4 - 1] += 1;

				break;
			case 6:
				System.out.println("谢谢使用，欢迎下次使用");
				return;
			default:
				System.out.println("谢谢使用，欢迎下次使用");
				return;
			}
			System.out.println("输入0返回");
			end = input.nextInt();
		} while (end == 0);
		System.out.println("谢谢使用，欢迎下次使用");
	}
}
