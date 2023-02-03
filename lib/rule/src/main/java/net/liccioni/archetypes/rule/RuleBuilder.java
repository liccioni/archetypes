package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operator.AND;
import static net.liccioni.archetypes.rule.Operator.EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.GREATER_THAN;
import static net.liccioni.archetypes.rule.Operator.GREATER_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.LESS_THAN;
import static net.liccioni.archetypes.rule.Operator.LESS_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.MATCHES;
import static net.liccioni.archetypes.rule.Operator.NOT;
import static net.liccioni.archetypes.rule.Operator.NOT_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operator.OR;
import static net.liccioni.archetypes.rule.Operator.XOR;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class RuleBuilder {

    private final List<RuleElement> elements = new ArrayList<>();

    private RuleBuilder() {
    }

    public PropositionDSL not(String name) {
        elements.add(new Proposition(name, false));
        elements.add(NOT);
        return new PropositionDSL(elements::add);
    }

    public PropositionDSL proposition(String name) {
        elements.add(new Proposition(name, false));
        return new PropositionDSL(elements::add);
    }

    public VariableDSL variable(String name) {
        elements.add(new Variable<>(name));
        return new VariableDSL(elements::add);
    }

    public StringVariableDSL stringVariable(String name) {
        elements.add(new Variable<>(name));
        return new StringVariableDSL(elements::add);
    }

    private Rule build(String name) {
        return new Rule(name, elements);
    }

    public static Rule newRule(String name, Function<RuleBuilder, PropositionDSL> builderBlock) {
        RuleBuilder builder = new RuleBuilder();
        builderBlock.apply(builder);
        return builder.build(name);
    }

    public static class PropositionDSL {

        private final Consumer<Operator> operationChain;

        private PropositionDSL(Consumer<Operator> operationChain) {
            this.operationChain = operationChain;
        }

        public PropositionDSL and(PropositionDSL other) {
            return buildPropositionDSL(other, AND);
        }

        public PropositionDSL or(PropositionDSL other) {
            return buildPropositionDSL(other, OR);
        }

        public PropositionDSL xor(PropositionDSL other) {
            return buildPropositionDSL(other, XOR);
        }

        private PropositionDSL buildPropositionDSL(PropositionDSL other, Operator operator) {
            operationChain.accept(operator);
            return other;
        }
    }

    public static class VariableDSL {

        private final Consumer<Operator> operationChain;

        private VariableDSL(Consumer<Operator> operationChain) {
            this.operationChain = operationChain;
        }

        public PropositionDSL equalTo(VariableDSL other) {
            return buildPropositionDSL(other, EQUAL_TO);
        }

        public PropositionDSL notEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, NOT_EQUAL_TO);
        }

        public PropositionDSL greaterThan(VariableDSL other) {
            return buildPropositionDSL(other, GREATER_THAN);
        }

        public PropositionDSL lessThan(VariableDSL other) {
            return buildPropositionDSL(other, LESS_THAN);
        }

        public PropositionDSL greaterThanOrEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, GREATER_THAN_OR_EQUAL_TO);
        }

        public PropositionDSL lessThanOrEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, LESS_THAN_OR_EQUAL_TO);
        }

        protected PropositionDSL buildPropositionDSL(VariableDSL other, Operator operator) {
            other.operationChain.accept(operator);
            return new PropositionDSL(other.operationChain);
        }
    }

    public static class StringVariableDSL extends VariableDSL {

        private StringVariableDSL(Consumer<Operator> operationChain) {
            super(operationChain);
        }

        public PropositionDSL matches(StringVariableDSL other) {
            return buildPropositionDSL(other, MATCHES);
        }
    }
}