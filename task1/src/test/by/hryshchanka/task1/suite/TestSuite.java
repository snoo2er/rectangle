package test.by.hryshchanka.task1.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import test.by.hryshchanka.task1.action.RectangleListCreatorTest;
import test.by.hryshchanka.task1.logic.RectangleLogicTest;
import test.by.hryshchanka.task1.parser.RectangleParserTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({RectangleParserTest.class, RectangleLogicTest.class, RectangleListCreatorTest.class})
public class TestSuite {

}