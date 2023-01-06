import sun.com.jdi.*;

public class Debugger {
    public static void main(String[] args) {
        // Create a new instance of the VirtualMachineManager class
        VirtualMachineManager vmm = Bootstrap.virtualMachineManager();

        // Get the list of running JVMs
        List<VirtualMachine> vms = vmm.runningVirtualMachines();

        // Attach to the first JVM in the list
        VirtualMachine vm = vms.get(0);
        vm.attach();

        // Set a breakpoint at line 100 of the main class
        Location location = vm.classesByName("main").get(0).locationsOfLine(10).get(0);
        vm.eventRequestManager().createBreakpointRequest(location).enable();
    }
}
