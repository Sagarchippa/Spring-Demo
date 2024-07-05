package demo;

import org.app.model.Employee;
import org.app.service.EmployeeService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Example1 {


    @Autowired
    WebApplicationContext webApplicationContext;

    @Mock
    EmployeeService employeeService;
    private MockMvc mockMvc;
    private final ModelMapper mapper=new ModelMapper();

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void a2_isWebAppContextInitialized(){
        Assert.assertNotNull(webApplicationContext);
    }

    @Test
    public void a1_testEmployee(){
        Mockito.when(employeeService.findById(2)).thenReturn(myCustomMethod());
        Employee employee=employeeService.findById(2);
        Assert.assertEquals(employee.getName(),"SAGA");
    }

    private Employee myCustomMethod() {
        Employee employee=new Employee();
        employee.setName("SAGA");
        employee.setId(1);
        return employee;
    }
}
