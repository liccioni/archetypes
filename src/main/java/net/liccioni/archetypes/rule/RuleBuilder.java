package net.liccioni.archetypes.rule;

import static net.liccioni.archetypes.rule.Operation.AND;
import static net.liccioni.archetypes.rule.Operation.EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.GREATER_THAN;
import static net.liccioni.archetypes.rule.Operation.GREATER_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.LESS_THAN;
import static net.liccioni.archetypes.rule.Operation.LESS_THAN_OR_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.MATCHES;
import static net.liccioni.archetypes.rule.Operation.NOT;
import static net.liccioni.archetypes.rule.Operation.NOT_EQUAL_TO;
import static net.liccioni.archetypes.rule.Operation.OR;
import static net.liccioni.archetypes.rule.Operation.XOR;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class RuleBuilder {

    private final List<RuleElement> elements = new ArrayList<>();

    private RuleBuilder() {
    }

    public PropositionDSL not(String name) {
        elements.add(new Proposition(name));
        elements.add(NOT.getOperator());
        return new PropositionDSL(elements::add);
    }

    public PropositionDSL proposition(String name) {
        elements.add(new Proposition(name));
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
            return buildPropositionDSL(other, AND.getOperator());
        }

        public PropositionDSL or(PropositionDSL other) {
            return buildPropositionDSL(other, OR.getOperator());
        }

        public PropositionDSL xor(PropositionDSL other) {
            return buildPropositionDSL(other, XOR.getOperator());
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
            return buildPropositionDSL(other, EQUAL_TO.getOperator());
        }

        public PropositionDSL notEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, NOT_EQUAL_TO.getOperator());
        }

        public PropositionDSL greaterThan(VariableDSL other) {
            return buildPropositionDSL(other, GREATER_THAN.getOperator());
        }

        public PropositionDSL lessThan(VariableDSL other) {
            return buildPropositionDSL(other, LESS_THAN.getOperator());
        }

        public PropositionDSL greaterThanOrEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, GREATER_THAN_OR_EQUAL_TO.getOperator());
        }

        public PropositionDSL lessThanOrEqualTo(VariableDSL other) {
            return buildPropositionDSL(other, LESS_THAN_OR_EQUAL_TO.getOperator());
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
            return buildPropositionDSL(other, MATCHES.getOperator());
        }
    }
}