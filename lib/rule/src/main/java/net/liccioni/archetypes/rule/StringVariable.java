package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operator.MATCHES;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringVariable extends Variable<String> {

    public StringVariable(String name, String value) {
        super(name, value);
    }

    public Proposition matches(Variable<?> other) {
        boolean newValue = isAssignableFrom(other) && internalMatches(other);
        return newProposition(newValue, other, MATCHES);
    }

    private boolean internalMatches(Variable<?> other) {
        Pattern pattern = Pattern.compile(this.getValue(), Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher((CharSequence) other.getValue());
        return matcher.matches();
    }
}
