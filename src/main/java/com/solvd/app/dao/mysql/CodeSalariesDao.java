package com.solvd.app.dao.mysql;

import com.solvd.app.dao.ICodeSalariesDao;
import com.solvd.app.tables.CodeSalaries;

import java.util.List;

public class CodeSalariesDao extends AbstractMysqlDao implements ICodeSalariesDao {
    @Override
    public List<CodeSalaries> getAll() {
        return null;
    }

    @Override
    public CodeSalaries get(int id) {
        return null;
    }

    @Override
    public void update(CodeSalaries codeSalaries) {

    }

    @Override
    public void delete(CodeSalaries codeSalaries) {

    }

    @Override
    public void create(CodeSalaries codeSalaries) {

    }
}
