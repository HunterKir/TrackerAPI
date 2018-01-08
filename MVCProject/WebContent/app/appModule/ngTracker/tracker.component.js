angular.module('appModule').component('tracker', {
	templateUrl : 'app/appModule/ngTracker/tracker.component.html',
	controller : function(trackerService) {
		var vm = this;
		vm.presets = [];
		vm.selectedPreset = null;
		vm.selectedButton = null;
		vm.changePresetName = false;
		vm.keyCodes = {
			'Escape' : {
				'name' : 'Escape',
				'value' : 1
			},
			'F1' : {
				'name' : 'F1',
				'value' : 59
			},
			'F2' : {
				'name' : 'F2',
				'value' : 60
			},
			'F3' : {
				'name' : 'F3',
				'value' : 61
			},
			'F4' : {
				'name' : 'F4',
				'value' : 62
			},
			'F5' : {
				'name' : 'F5',
				'value' : 63
			},
			'F6' : {
				'name' : 'F6',
				'value' : 64
			},
			'F7' : {
				'name' : 'F7',
				'value' : 65
			},
			'F8' : {
				'name' : 'F8',
				'value' : 66
			},
			'F9' : {
				'name' : 'F9',
				'value' : 67
			},
			'F10' : {
				'name' : 'F10',
				'value' : 68
			},
			'F11' : {
				'name' : 'F11',
				'value' : 87
			},
			'F12' : {
				'name' : 'F12',
				'value' : 88
			},
			'F13' : {
				'name' : 'F13',
				'value' : 91
			},
			'F14' : {
				'name' : 'F14',
				'value' : 92
			},
			'F15' : {
				'name' : 'F15',
				'value' : 93
			},
			'F16' : {
				'name' : 'F16',
				'value' : 99
			},
			'F17' : {
				'name' : 'F17',
				'value' : 100
			},
			'F18' : {
				'name' : 'F18',
				'value' : 101
			},
			'F19' : {
				'name' : 'F19',
				'value' : 102
			},
			'F20' : {
				'name' : 'F20',
				'value' : 103
			},
			'F21' : {
				'name' : 'F21',
				'value' : 104
			},
			'F22' : {
				'name' : 'F22',
				'value' : 105
			},
			'F23' : {
				'name' : 'F23',
				'value' : 106
			},
			'F24' : {
				'name' : 'F24',
				'value' : 107
			},
			'Backquote' : {
				'name' : 'Backquote',
				'value' : 41
			},
			'1' : {
				'name' : '1',
				'value' : 2
			},
			'2' : {
				'name' : '2',
				'value' : 3
			},
			'3' : {
				'name' : '3',
				'value' : 4
			},
			'4' : {
				'name' : '4',
				'value' : 5
			},
			'5' : {
				'name' : '5',
				'value' : 6
			},
			'6' : {
				'name' : '6',
				'value' : 7
			},
			'7' : {
				'name' : '7',
				'value' : 8
			},
			'8' : {
				'name' : '8',
				'value' : 9
			},
			'9' : {
				'name' : '9',
				'value' : 10
			},
			'0' : {
				'name' : '0',
				'value' : 11
			},
			'-' : {
				'name' : '-',
				'value' : 12
			},
			'=' : {
				'name' : '=',
				'value' : 13
			},
			'Backspace' : {
				'name' : 'Backspace',
				'value' : 14
			},
			'Tab' : {
				'name' : 'Tab',
				'value' : 15
			},
			'CapsLock' : {
				'name' : 'CapsLock',
				'value' : 58
			},
			'A' : {
				'name' : 'A',
				'value' : 30
			},
			'B' : {
				'name' : 'B',
				'value' : 48
			},
			'C' : {
				'name' : 'C',
				'value' : 46
			},
			'D' : {
				'name' : 'D',
				'value' : 32
			},
			'E' : {
				'name' : 'E',
				'value' : 18
			},
			'F' : {
				'name' : 'F',
				'value' : 33
			},
			'G' : {
				'name' : 'G',
				'value' : 34
			},
			'H' : {
				'name' : 'H',
				'value' : 35
			},
			'I' : {
				'name' : 'I',
				'value' : 23
			},
			'J' : {
				'name' : 'J',
				'value' : 36
			},
			'K' : {
				'name' : 'K',
				'value' : 37
			},
			'L' : {
				'name' : 'L',
				'value' : 38
			},
			'M' : {
				'name' : 'M',
				'value' : 50
			},
			'N' : {
				'name' : 'N',
				'value' : 49
			},
			'O' : {
				'name' : 'O',
				'value' : 24
			},
			'P' : {
				'name' : 'P',
				'value' : 25
			},
			'Q' : {
				'name' : 'Q',
				'value' : 16
			},
			'R' : {
				'name' : 'R',
				'value' : 19
			},
			'S' : {
				'name' : 'S',
				'value' : 31
			},
			'T' : {
				'name' : 'T',
				'value' : 20
			},
			'U' : {
				'name' : 'U',
				'value' : 22
			},
			'V' : {
				'name' : 'V',
				'value' : 47
			},
			'W' : {
				'name' : 'W',
				'value' : 17
			},
			'X' : {
				'name' : 'X',
				'value' : 45
			},
			'Y' : {
				'name' : 'Y',
				'value' : 21
			},
			'Z' : {
				'name' : 'Z',
				'value' : 44
			},
			'OpenSquareBracket' : {
				'name' : 'OpenSquareBracket',
				'value' : 26
			},
			'CloseSquareBracket' : {
				'name' : 'CloseSquareBracket',
				'value' : 27
			},
			'Backslash' : {
				'name' : 'Backslash',
				'value' : 43
			},
			'Semicolon' : {
				'name' : 'Semicolon',
				'value' : 39
			},
			'Quote' : {
				'name' : 'Quote',
				'value' : 40
			},
			'Enter' : {
				'name' : 'Enter',
				'value' : 28
			},
			'Comma' : {
				'name' : 'Comma',
				'value' : 51
			},
			'Period' : {
				'name' : 'Period',
				'value' : 52
			},
			'ForwardSlash' : {
				'name' : 'ForwardSlash',
				'value' : 53
			},
			'Space' : {
				'name' : 'Space',
				'value' : 57
			},
			'Shift' : {
				'name' : 'Shift',
				'value' : 42
			},
			'Control' : {
				'name' : 'Control',
				'value' : 29
			},
			'Alt' : {
				'name' : 'Alt',
				'value' : 56
			},
			'Windows/Command' : {
				'name' : 'Windows/Command',
				'value' : 3675
			},
			'Context' : {
				'name' : 'Context',
				'value' : 3677
			}

		};

		vm.reloadPresets = function(uid) {
			trackerService.index(uid).then(function(data) {
				vm.presets = data.data;
			});
		};

		vm.reloadPresets();

		vm.selectPreset = function(uid, pid) {
			trackerService.showPreset(uid, pid).then(function(preset) {
				vm.selectedPreset = preset.data;
			});
		};

		vm.selectButton = function(uid, pid, bid) {
			trackerService.showButton(uid, pid, bid).then(function(button) {
				vm.selectedButton = button.data;
			});
		};

		vm.deletePreset = function(uid, pid) {
			trackerService.deletePreset(uid, pid).then(function() {
				vm.selectPreset = null;
				vm.reloadPresets();
			});
		};

		vm.deleteButton = function(uid, pid, bid) {
			trackerService.deleteButton(uid, pid, bid).then(function() {
				vm.selectButton = null;
				vm.reloadPresets();
				vm.selectPreset(uid, pid);
			});
		};

		vm.createUser = function(user) {
			trackerService.createUser(user).then(function() {
				// not yet implemented
			});
		};

		vm.createPreset = function(uid, preset) {
			trackerService.createPreset(uid, preset).then(function() {
				vm.reloadPresets();
			});
		};

		vm.createButton = function(uid, pid, button) {
			trackerService.createButton(uid, pid, button).then(function() {
				vm.reloadPresets();
			})
		};

		vm.updateUser = function(uid, user) {
			trackerService.updateUser(uid, user).then(function() {
				// not yet implemented
			});
		};

		vm.updatePreset = function(uid, pid, preset) {
			trackerService.updatePreset(uid, pid, preset).then(function(preset) {
				vm.selectedPreset = preset.data;
				vm.reloadPresets();
			});
		};

		vm.updateButton = function(uid, pid, bid, button) {
			trackerService.updateButton(uid, pid, bid, button).then(function(button) {
				vm.selectedButton = button.data;
				vm.reloadPresets();
				vm.selectPreset(uid, pid);
			});
		};
	},
	controllerAs : 'vm'
});
