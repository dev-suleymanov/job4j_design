package ru.job4j.generic;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleIsSeller() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("seller");
    }

    @Test
    void whenAddAndFindThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        Role result = roleStore.findById("2");
        assertThat(result).isNull();
    }

    @Test
    void whenAddDuplicateAndFindUsernameIsSeller() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        roleStore.add(new Role("1", "consultant"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("seller");
    }

    @Test
    void whenReplaceThenUserNameIsConsultant() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        roleStore.replace("1", new Role("1", "consultant"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("consultant");
    }

    @Test
    void whenNoReplaceRoleThenNoChangeRole() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        roleStore.replace("2", new Role("2", "consultant"));
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isNotEqualTo("consultant");
    }

    @Test
    void whenDeleteRoleThenRoleIsNull() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        roleStore.delete("1");
        assertThat(roleStore.findById("1")).isNull();
    }

    @Test
    void whenNoDeleteRoleThenRoleIsSeller() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        roleStore.delete("2");
        Role result = roleStore.findById("1");
        assertThat(result.getRole()).isEqualTo("seller");
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        boolean result = roleStore.replace("1", new Role("1", "consultant"));
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        boolean result = roleStore.replace("2", new Role("1", "consultant"));
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteOkThenTrue() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        boolean result = roleStore.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenDeleteNotOkThenFalse() {
        RoleStore roleStore = new RoleStore();
        roleStore.add(new Role("1", "seller"));
        boolean result = roleStore.delete("2");
        assertThat(result).isFalse();
    }
}