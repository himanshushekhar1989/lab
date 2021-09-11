package lab;

public class LRUCacheTest {
	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache<>(2);
		cache.put(1, "Himanshu");
		cache.put(2, "Shekhar");
		cache.get(1);
		cache.put(3, "Rolly");
		cache.get(3);
		cache.put(4,"Mintu");


		System.out.println(cache);
	}
}
