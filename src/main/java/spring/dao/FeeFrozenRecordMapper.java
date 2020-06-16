package spring.dao;

import entity.FeeFrozenRecord;

public interface FeeFrozenRecordMapper {
    FeeFrozenRecord selectById(String id);

    void updateByPrimaryKey(FeeFrozenRecord feeFrozenRecord);

    void insert(FeeFrozenRecord feeFrozenRecord);
}
