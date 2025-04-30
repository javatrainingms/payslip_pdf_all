package com.pdf.backup1;
import java.util.*;

public class ShiftScheduler {
    private static final int TOTAL_EMPLOYEES = 80;
    private static final int EMPLOYEES_PER_SHIFT = 5;
    private static final int EMPLOYEES_PER_OFF_DAY = TOTAL_EMPLOYEES / 7;
    private static final String[] SHIFTS = {"08:00-14:00", "14:00-20:00", "20:00-08:00"};
    private static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        // Initialize employees
        for (int i = 1; i <= TOTAL_EMPLOYEES; i++) {
            employees.add(new Employee(i));
        }
        
        // Generate shift schedule
        generateSchedule(employees);
        
        // Print the schedule in table format
        printSchedule(employees);
    }
    
    private static void generateSchedule(List<Employee> employees) {
        Collections.shuffle(employees); // Shuffle to randomize week-offs
        
        for (int day = 0; day < 7; day++) {
            Set<Integer> offEmployees = new HashSet<>();
            
            // Assign week-off to a subset of employees
            for (int i = day * EMPLOYEES_PER_OFF_DAY; i < (day + 1) * EMPLOYEES_PER_OFF_DAY; i++) {
                employees.get(i).assignOff(DAYS[day]);
                offEmployees.add(employees.get(i).getId());
            }
            
            int shiftIndex = 0;
            int count = 0;
            
            for (Employee emp : employees) {
                if (!offEmployees.contains(emp.getId())) {
                    emp.assignShift(DAYS[day], SHIFTS[shiftIndex]);
                    count++;
                    if (count % EMPLOYEES_PER_SHIFT == 0) {
                        shiftIndex = (shiftIndex + 1) % SHIFTS.length;
                    }
                }
            }
        }
    }
    
    private static void printSchedule(List<Employee> employees) {
        System.out.printf("%-12s", "Employee");
        for (String day : DAYS) {
            System.out.printf("%-15s", day);
        }
        System.out.println();
        System.out.println("=".repeat(120));
        
        for (Employee emp : employees) {
            System.out.printf("%-12s", "Emp_" + emp.getId());
            for (String day : DAYS) {
                System.out.printf("%-15s", emp.getSchedule().get(day));
            }
            System.out.println();
        }
    }
}

class Employee {
    private final int id;
    private final Map<String, String> schedule;
    
    public Employee(int id) {
        this.id = id;
        this.schedule = new LinkedHashMap<>();
    }
    
    public int getId() {
        return id;
    }
    
    public void assignShift(String day, String shift) {
        schedule.put(day, shift);
    }
    
    public void assignOff(String day) {
        schedule.put(day, "Week_Off");
    }
    
    public Map<String, String> getSchedule() {
        return schedule;
    }
}
