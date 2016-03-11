package fakeCoins;

public class FakeCoins {
	private Coins bag;

	public FakeCoins(Coins bag) {
		this.bag = bag;
	}

	public int findFake() {
		// TODO Auto-generated method stub
		return 0;
	}

	private int recFindFake(int left, int right) {
		int result = 0;
		if ((right - left) == 2) {
			ScalePosition sol = bag.weigh(left, left, left + 1, left + 1);
			ScalePosition sol2 = bag.weigh(left + 1, left + 1, right, right);
			if (sol == ScalePosition.EQUAL)
				result = right;
			else if (sol2 == ScalePosition.EQUAL)
				result = left;
			else
				result = left + 1;
		} else if ((right - left) == 4 || (right - left) == 5) {
			ScalePosition sol = bag.weigh(left, left + 1, left + 2, left + 3);
			if (sol == ScalePosition.EQUAL) {
				return recFindFake(right - 2, right);

			} else {
				sol = bag.weigh(left, left, left + 1, left + 1);
				if (sol == ScalePosition.EQUAL)
					return recFindFake(left + 1, left + 3);
				else
					return recFindFake(left, left + 2);
			}
		} else if ((right - left) == 4) {
			ScalePosition sol = bag.weigh(left, left, left + 1, left + 1);
			if (sol == ScalePosition.EQUAL)
				return recFindFake(left + 1, right);
			else
				return recFindFake(left, left + 2);
		} else {
			int centro = (right + left) / 2;
			int cuarto;
			if (centro % 2 == 0)
				centro = centro + 1;
			cuarto = (right + centro) / 2;
			ScalePosition sol = bag.weigh(left, cuarto, cuarto, centro);
			if (sol == ScalePosition.EQUAL)
				return recFindFake(centro, right);
			else
				return recFindFake(left, centro);
		}

		return result;
	}
}
