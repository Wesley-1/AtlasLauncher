package atlaslauncher.atlaslauncher.loader;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair<A, B> {

    private final A first;
    private final B second;

    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
