package net.liccioni.archetypes.relationship;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.val;
import net.liccioni.archetypes.party.Organization;
import net.liccioni.archetypes.party.OrganizationName;
import net.liccioni.archetypes.party.Person;
import net.liccioni.archetypes.party.PersonName;
import net.liccioni.archetypes.rule.RuleBuilder;
import net.liccioni.archetypes.rule.RuleSet;
import org.junit.jupiter.api.Test;

class PartyRelationshipTest {

    @Test
    void shouldFormRelationships() {

        val projectManager = PartyRoleType.builder().name("ProjectManager")
                .requirementsForRole(new RuleSet("", RuleBuilder.newRule("", b -> b.proposition("pmCertified"))))
                .build();
        val architect = PartyRoleType.builder().name("Architect").build();
        val developer = PartyRoleType.builder().name("Developer").build();
        val technicalConsultant = PartyRoleType.builder().name("TechnicalConsultant").build();
        val employingProject = PartyRoleType.builder().name("TechnicalConsultant").build();

        val jimCapabilities = Capabilities.builder().build();
        jimCapabilities.addProposition("pmCertified", true);
        val jim = Person.builder().personName(PersonName.builder().givenName("Jim").build())
                .capabilities(jimCapabilities).build();
        val ila = Person.builder().personName(PersonName.builder().givenName("Ila").build()).build();
        val ronald = Person.builder().personName(PersonName.builder().givenName("Ronald").build()).build();
        val archetypeCartridgeProject = Organization.builder().organizationName(OrganizationName.builder()
                .name("ArchetypeCartridgeProject")
                .build()).build();

        projectManager.getConstraints().add(PartyRoleConstraint.builder().typeOfParty(Person.class).build());
        if (projectManager.canPlayRole(jim, jim.getCapabilities())) {
            jim.getRoles().add(PartyRole.builder().type(projectManager).build());
        }

        jim.getRoles().add(PartyRole.builder().type(architect).build());

        ila.getRoles().add(PartyRole.builder().type(developer).build());

        ronald.getRoles().add(PartyRole.builder().type(technicalConsultant).build());

        val employingProjectRole = PartyRole.builder().type(employingProject).build();
        archetypeCartridgeProject.getRoles().add(employingProjectRole);

        val memberOfProject = PartyRelationshipType.builder().name("MemberOfProject").build();

        val relationships = Stream.of(jim, ila, ronald)
                .flatMap(p -> p.getRoles().stream())
                .map(p -> PartyRelationship.builder()
                        .type(memberOfProject)
                        .client(employingProjectRole)
                        .supplier(p)
                        .build()).collect(Collectors.toList());

        assertThat(relationships).hasSize(4);
    }
}