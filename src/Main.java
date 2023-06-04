public class Main {
    public static void main(String[] args) {


        Mapa<Integer, String> mapa = new Mapa<>();
        mapa.put(1, "d");
        mapa.put(2, "e");
        mapa.put(7, "asdfgh*");
        mapa.put(7, "f");
        mapa.put(16, "c");
        System.out.println();

        System.out.println(mapa.get(1));
        System.out.println(mapa.get(106));
        System.out.println(mapa.get(7));
        System.out.println();

        System.out.println(mapa.remove(2));

        System.out.println(mapa.containsKey(1));
        System.out.println(mapa.containsValue("d"));

        System.out.println(mapa.replays(1, "1"));
        System.out.println();
        System.out.println(mapa.getSize());

    }
}