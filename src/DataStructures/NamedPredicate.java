package DataStructures;

import Cards.CardTypes;

import java.util.function.Predicate;

public class NamedPredicate<T> implements Predicate<T> {
    private final String name;
    private final Predicate<T> predicate;

    public final CardTypes cardType;


    public NamedPredicate(String name, Predicate<T> predicate, CardTypes card) {
        this.name = name;
        this.predicate = predicate;
        this.cardType = card;
    }

    @Override
    public boolean test(T t) {
        return predicate.test(t);
    }

    @Override
    public String toString() {
        return name;
    }
}

