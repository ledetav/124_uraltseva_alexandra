package task;

public enum Direction {
    West("west"), East("east"), North("north"), South("south");

    private String direct;

    Direction(String direct){
        this.direct = direct;
    }

    private double startDist, startX, startY;

    public Vector2 move(Vector2 start, double distance) {
        this.startX = start.getX();
        this.startY = start.getY();
        this.startDist = distance;

        switch (direct) {
            case "west": {
                startX -= startDist;

                Vector2 v = new Vector2(startX, startY);
                return v;
            }
            case "east": {
                startX += startDist;

                Vector2 v = new Vector2(startX, startY);
                return v;
            }
            case "south": {
                startY += startDist;

                Vector2 v = new Vector2(startX, startY);
                return v;
            }
            default: {
                startY -= startDist;

                Vector2 v = new Vector2(startX, startY);
                return v;
            }
        }
    }
}